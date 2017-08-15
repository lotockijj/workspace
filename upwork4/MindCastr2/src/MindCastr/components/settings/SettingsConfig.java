package MindCastr.components.settings;

import static MindCastr.persistent.DirectoryManager.CreateFolderIfNotExist;
import static MindCastr.persistent.DirectoryManager.getMindCastrFolder;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class SettingsConfig {
    
    private final static PropertiesConfiguration props = new PropertiesConfiguration();
    
    private static final File configFile;
    static {
//        String configFileName = Constants.CONFIGURATION_FILES_DIRECTORY + "/" + Constants.CONFIGURATION_FILE_NAME;
//        URL fileURL = SettingsConfig.class.getResource(configFileName);
//        assert(fileURL != null/*<=> the file exists*/);
        CreateFolderIfNotExist(getMindCastrFolder() + File.separator + "Configuration");
        configFile = new File(getMindCastrFolder() + File.separator + "Configuration" + File.separator + "configuration.properties");
        if(!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error message: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    
    private static SettingsConfig settingsConfig;
    
    private TimeSettings timeSettings;
    private MessageLocationSettings msgLocationSettings;
    private FontSettings fontSettings;
    private MessageOrderSettings msgOrderSettings;
    private CategorySettings categorySettings;
    
    public static SettingsConfig getInstance() {
        synchronized(props) {
            if(settingsConfig == null) {
                settingsConfig = new SettingsConfig();
            }
        }
        return settingsConfig;
    }
    
    private SettingsConfig() {
        try {
            props.load(configFile);
        } catch (ConfigurationException ex) {
            ex.printStackTrace();
            //thince the file is inside the jar then this operation should
            //not be erroneous.
            assert(false);
        }               
        initProperties();
    }
    
    private void initProperties() {
        timeSettings = new TimeSettings(props);
        msgLocationSettings = new MessageLocationSettings(props);
        fontSettings = new FontSettings(props);
        msgOrderSettings = new MessageOrderSettings(props);
        categorySettings = new CategorySettings(props);
    }
    
    public void setAndSaveDefaults() {
        timeSettings.reset();
        msgLocationSettings.reset();
        fontSettings.reset();
        msgOrderSettings.reset();
        categorySettings.reset();
        setAndSaveValues();
    }
    
    public void setAndSaveValues() {
        props.clear();
        timeSettings.setToProps();
        msgLocationSettings.setToProps();
        fontSettings.setToProps();
        msgOrderSettings.setToProps();
        categorySettings.setToProps();
        savePropertyConfigs();
    }
    
    private void savePropertyConfigs() {
        try {
            props.save(configFile);
        } catch (ConfigurationException ex) {
            ex.printStackTrace();
            //thince the file is inside the jar then this operation should
            //not be erroneous.
            assert(false);
        }
    }
    
    public TimeSettings getTimeSettings() {
        return timeSettings;
    }
    
    public MessageLocationSettings getMessageLocationSettings() {
        return msgLocationSettings;
    }
    
    public FontSettings getFontSettings() {
        return fontSettings;
    }
    
    public MessageOrderSettings getMessageOrderSettings() {
        return msgOrderSettings;
    }
    
    public CategorySettings getCategorySettings() {
        return categorySettings;
    }
    
    public static abstract class Settings {
        protected final PropertiesConfiguration props;
        
        public Settings(final PropertiesConfiguration props) {
            assert(props != null);
            this.props = props;
            init();
        }
        
        private void init() {
            load();
        }
        
        protected abstract void load();
        
        protected abstract void reset();
        
        protected abstract void setToProps();
    }
    
    public static class TimeSettings extends Settings {
        
        private static final int DISPLAY_EVERY_SECONDS_DEFAULT = 3;
        private static final long DISPLAY_FOR_MILLISECONDS_DEFAULT = 88;

        private static final String DISPLAY_EVERY_SECONDS_NAME = "displayEverySeconds";
        private static final String DISPLAY_FOR_MILLISECONDS_NAME = "displayForMilliseconds";
        public volatile int displayEverySecondsValue;
        public volatile long displayForMillisecondsValue;
        
        private TimeSettings(final PropertiesConfiguration props) {
            super(props);
        }
        
        @Override
        protected void load() {
            displayEverySecondsValue = props.getInt(DISPLAY_EVERY_SECONDS_NAME, DISPLAY_EVERY_SECONDS_DEFAULT);
            displayForMillisecondsValue = props.getLong(DISPLAY_FOR_MILLISECONDS_NAME, DISPLAY_FOR_MILLISECONDS_DEFAULT);
        }
        
        @Override
        protected void reset() {
            displayEverySecondsValue = DISPLAY_EVERY_SECONDS_DEFAULT;
            displayForMillisecondsValue = DISPLAY_FOR_MILLISECONDS_DEFAULT;
        }
        
        @Override
        protected void setToProps() {
            props.setProperty(DISPLAY_EVERY_SECONDS_NAME, displayEverySecondsValue);
            props.setProperty(DISPLAY_FOR_MILLISECONDS_NAME, displayForMillisecondsValue);
        }
        
    }
    
    public static class MessageLocationSettings extends Settings {
        
        private static final MessageLocationEnum MESSAGE_LOCATION_DEFAULT = MessageLocationEnum.RANDOM;
        private static final String MESSAGE_LOCATION_NAME = "messageLocation";
        public MessageLocationEnum messageLocation;
        
        private MessageLocationSettings(final PropertiesConfiguration props) {
            super(props);
        }
        
        @Override
        protected void load() {
            String location = props.getString(MESSAGE_LOCATION_NAME, MESSAGE_LOCATION_DEFAULT.location);
            messageLocation = MessageLocationEnum.fromLocation(location);
        }
        
        @Override
        protected void reset() {
            messageLocation = MESSAGE_LOCATION_DEFAULT;
        }
        
        @Override
        protected void setToProps() {
            props.setProperty(MESSAGE_LOCATION_NAME, messageLocation);
        }
    }
    
    public static enum MessageLocationEnum {
        RANDOM("random"),
        CENTER("center"),
        BOTTOM_RIGHT("bottom_right");
        
        public final String location;
        
        private MessageLocationEnum(String location) {
            this.location = location;
        }
        
        public static MessageLocationEnum fromLocation(String location) {
            MessageLocationEnum result = null;
            if(location != null && !location.isEmpty()) {
                for(MessageLocationEnum enumItem : MessageLocationEnum.values()) {
                    if(enumItem.location.equalsIgnoreCase(location)) {
                        result = enumItem;
                        break;
                    }
                }
            } else {
                result = RANDOM;
            }
            return result;
        }
    }
    
    public static class FontSettings extends Settings {
        private static final String FONT_DEFAULT = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()[0];
        private static final int FONT_SIZE_DEFAULT = 48;
        private static final Color COLOR_DEFAULT = Color.BLACK;
        private static final int TRANSPARENCY_DEFAULT = 100;
        
        private static final String FONT_NAME = "fontName";
        private static final String FONT_SIZE_NAME = "fontSize";
        private static final String COLOR_NAME = "color";
        private static final String TRANSPARENCY_NAME = "transparency";
        
        public volatile String font;
        public volatile int fontSize;
        public volatile Color color;
        public volatile int transparency;
        
        private FontSettings(final PropertiesConfiguration props) {
            super(props);
        }
        
        @Override
        protected void load() {
            font = props.getString(FONT_NAME, FONT_DEFAULT);
            fontSize = props.getInt(FONT_SIZE_NAME, FONT_SIZE_DEFAULT);
            int rgb = props.getInt(COLOR_NAME, COLOR_DEFAULT.getRGB());
            color = new Color(rgb);
            transparency = props.getInt(TRANSPARENCY_NAME, TRANSPARENCY_DEFAULT);
        }
        
        @Override
        protected void reset() {
            font = FONT_DEFAULT;
            fontSize = FONT_SIZE_DEFAULT;
            color = COLOR_DEFAULT;
            transparency = TRANSPARENCY_DEFAULT;
        }
        
        @Override
        protected void setToProps() {
            props.setProperty(FONT_NAME, font);
            props.setProperty(FONT_SIZE_NAME, fontSize);
            props.setProperty(COLOR_NAME, color.getRGB());
            props.setProperty(TRANSPARENCY_NAME, transparency);
        }
    }
    
    public static class MessageOrderSettings extends Settings {
        
        private static final boolean IS_ORDERED_DEFAULT = true;
        
        private static final String IS_ORDERED_NAME = "isOrdered";

        public volatile boolean isOrdered;

        private MessageOrderSettings(final PropertiesConfiguration props) {
            super(props);
        }
        
        @Override
        protected void load() {
            isOrdered = props.getBoolean(IS_ORDERED_NAME, IS_ORDERED_DEFAULT);
        }
        
        @Override
        protected void reset() {
            isOrdered = IS_ORDERED_DEFAULT;
        }
        
        @Override
        protected void setToProps() {
            props.setProperty(IS_ORDERED_NAME, isOrdered);
        }
    }
    
    public static class CategorySettings extends Settings {
        
        private static final String CATEGORIES_NAME = "categories";
        private static final String SELECTED_CATEGORY_NAMES = "selectedCategories";

        public Map<String, List<String>> categories;
        
        public Set<String> selectedCategoryNames;
        
        private CategorySettings(final PropertiesConfiguration props) {
            super(props);
        }
        
        @Override
        protected void load() {
            selectedCategoryNames = new TreeSet<String>();
            categories = new LinkedHashMap<String, List<String>>();
            List<String> categoryNames = props.getList(CATEGORIES_NAME);
            if(categoryNames == null) {
                return;
            }
            for(String categoryName : categoryNames) {
                List<String> categoryItems = props.getList(categoryName);
                if(categoryItems == null) {
                    continue;
                }
                categories.put(categoryName, categoryItems);
            }
            
            List<String> selectedCategoriesList = props.getList(SELECTED_CATEGORY_NAMES);
            selectedCategoryNames.addAll(selectedCategoriesList);
        }
        
        @Override
        protected void reset() {
            //nothing to do
        }
        
        @Override
        protected void setToProps() {
            for(Map.Entry<String, List<String>> entry : categories.entrySet()) {
                String categoryName = entry.getKey();
                List<String> categoryItems = entry.getValue();
                props.addProperty(CATEGORIES_NAME, categoryName);
                for(String categoryItem : categoryItems) {
                    props.addProperty(categoryName, categoryItem);
                }
            }
            for(String selectedCategoryName : selectedCategoryNames) {
                props.addProperty(SELECTED_CATEGORY_NAMES, selectedCategoryName);
            }
        }
    }
    
}
