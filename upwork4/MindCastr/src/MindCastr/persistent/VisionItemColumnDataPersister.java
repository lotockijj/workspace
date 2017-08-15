package MindCastr.persistent;

import MindCastr.components.visionboard.ImageItem;
import MindCastr.components.visionboard.TextItem;
import MindCastr.components.visionboard.VisionItem;
import MindCastr.components.visionboard.VisionItemContent;
import MindCastr.constants.Constants;
import static MindCastr.persistent.DirectoryManager.CreateFolderIfNotExist;
import static MindCastr.persistent.DirectoryManager.getMindCastrFolder;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class VisionItemColumnDataPersister {

    private final File itemsFile;

    public final VisionItemColumnDataCache itemDataCache = new VisionItemColumnDataCache();

    public VisionItemColumnDataPersister(int columnNumber) {
//        String  itemsFileUrl = Constants.CONFIGURATION_FILES_DIRECTORY + "/" + Constants.ITEMS_FILE_BASE_NAME + columnNumber;
//        URL fileURL = getClass().getResource(itemsFileUrl);
//        assert(fileURL != null/*<=> the file exists*/);
        CreateFolderIfNotExist(getMindCastrFolder() + File.separator + "Configuration");
        itemsFile = new File(getMindCastrFolder() + File.separator + "Configuration"  + File.separator + Constants.ITEMS_FILE_BASE_NAME + columnNumber);
        if (!itemsFile.exists())
            try {
                itemsFile.createNewFile();
            } catch(Exception e) {};
        loadItems();
    }

    private void loadItems() {
        List<String> readLines;
        try {
            readLines = FileUtils.readLines(itemsFile);
        } catch (IOException ex) {
            ex.printStackTrace();
            //do nothing, consider this as no any items in the repository
            return;
        }

        assert(readLines != null);
        Iterator<String> fileLinesIterator = readLines.iterator();
        boolean defectFoundAndFixed = false;
        while(fileLinesIterator.hasNext()) {
            String line = fileLinesIterator.next();
            VisionItemContent itemContent = VisionItemContent.fromString(line);
            if(itemContent == null) {
                fileLinesIterator.remove();
                defectFoundAndFixed = true;
                continue;
            }
            VisionItem item = null;
            if(itemContent.type == VisionItemContent.ContentType.IMAGE_URL) {
                if (!new File(itemContent.subliminalContent).exists()){
                    fileLinesIterator.remove();
                    defectFoundAndFixed = true;
                    continue;
                } else {
                    Dimension imgSize = ImageUtil.getImgSizeWithoutLoad(itemContent.subliminalContent);
                    item = new ImageItem(itemContent.subliminalContent, imgSize);
                    ImageLoader.getLoader().addImageToCopy(itemContent.subliminalContent, (ImageItem)item);
                }
            } else {
                item = new TextItem(itemContent.subliminalContent);
            }
            itemDataCache.addItemToCache(item);
        }
        if (defectFoundAndFixed) {
            try {
                FileUtils.writeLines(itemsFile, readLines, false);
            } catch (IOException ex) {
                ex.printStackTrace();
                //do nothing, next time will try remove defects again
            }
        }
    }

    public VisionItem addItem(VisionItem visionItem) {
        if(visionItem == null) {
            return null;
        }
        try {
            FileUtils.writeLines(itemsFile, Collections.singletonList(visionItem.toString()), true);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        itemDataCache.addItemToCache(visionItem);
        return visionItem;
    }

    public void removeItem(int index, boolean removeImage) {
        VisionItem removedItem = itemDataCache.removeItemFromCache(index);
        if (removedItem != null) {
            try {
                if (removedItem.content.type == VisionItemContent.ContentType.IMAGE_URL && removeImage) {
                    ImageUtil.removeImage(removedItem.content.subliminalContent);
                }
                    FileUtils.writeLines(itemsFile, itemDataCache.getVisionItemStrings(), false);
            } catch (IOException ex) {
                ex.printStackTrace();
                //should not happen in normal case
                //TODO: do handling
            }
        }
    }

    public List<VisionItem> getVisionItems() {
        return itemDataCache.getVisionItems();
    }

    public List<String> getVisionItemStrings() {
        return itemDataCache.getVisionItemStrings();
    }

    public int size() {
        return itemDataCache.getVisionItemStrings().size();
    }

}
