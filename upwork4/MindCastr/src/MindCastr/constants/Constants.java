package MindCastr.constants;

import java.awt.*;
import java.io.File;

import static MindCastr.persistent.DirectoryManager.getMindCastrFolder;
import static MindCastr.utils.Utils.getJarFilePath;

public class Constants {

    public static final Font PANEL_TITLE_FONT_SETTINGS = new Font("Tahoma", Font.BOLD, 13);
    public static final Font PANEL_TITLE_FONT_NO_BOLD = new Font("HelveticaNeue", Font.PLAIN, 20);
    public static final Font INNER_COMPONENT_FONT = new Font("Tahoma", 0, 14);
    public static final Font INNER_COMPONENT_FONT_BOLD = new Font("Tahoma", Font.BOLD, 14);
    public static final Font INNER_COMPONENT_SMALL_FONT = new Font("Tahoma", 0, 11);
    public static final Font TUTORIAL_FONT = new Font("HelveticaNeue", Font.PLAIN, 40);
    public static final Font PANEL_LOGIN_FONT_NO_BOLD = new Font("HelveticaNeue", Font.PLAIN, 16);
    public static final Font PANEL_LOGIN_FONT_BOLD = new Font("HelveticaNeue", Font.BOLD, 16);
    public static final Color TEXT_COLOR = new Color(2, 2, 2);
    public static final Color HEADER_TEXT_COLOR = new Color(188, 190, 196);
    public static final Color TEXT_COLOR_SECONDS = new Color(110, 110, 110);
    public static final Color TEXT_COLOR_DARK = new Color(75, 75, 75);
    public static final Color TEXT_COLOR_BLUE = new Color(52,154,211);
    public static final String CRYPTO_KEY = "Q1w2e3r4t5Ekjhs5";
    public static final String NET_MAC_FILE_NAME = "tmpOsinfo";
    public static final String NET_MAC_FILE_NAME_ENCRYPTED = "osinfo";
    public static final String NET_MAC_FILE_NAME_DECRYPTED = "dosinfo";
    //public static final Color MAIN_PANEL_BORDER_COLOR = new Color(196,194,196);

    public static final int SHADOW_SIZE = 25;

    public static final int MAIN_WIN_WIDTH = 772;
    public static final int MAIN_WIN_HEIGHT = 682;

    public static final float MAIN_HEADER_RELATIVE_FACTOR = .02f;
    public static final float MAIN_PLAYBACK_RELATIVE_FACTOR = .09f;

    public static final int SHADOW_PANEL_WIDTH = MAIN_WIN_WIDTH -  (SHADOW_SIZE * 2);
    public static final int SHADOW_PANEL_HEIGHT = MAIN_WIN_HEIGHT - (int) (MAIN_HEADER_RELATIVE_FACTOR * MAIN_WIN_HEIGHT) - (SHADOW_SIZE * 2);
    // 1.0 - no opacity, 0.0 - full opacity
    public static final Color SHADOW_COLOR = new Color(0, 0, 0, 0.1f);


    public static final Color PLAYBACK_PANEL_COLOR =  Color.WHITE;
    public static final Color VISION_ITEM_COLOR = Color.WHITE;
    public static final int VISION_ITEM_HEIGHT = (int)(0.33 * MAIN_WIN_WIDTH);//???

    public static final int SCROLLBAR_PREFERRED_WIDTH = 15;

    public static final String ITEMS_FILE_BASE_NAME = "itemsCol";

    public static final String UPPER_GUIDE_TEXT_LABEL = "Upload something on your vision board to get started!";
    public static final String LOWER_GUIDE_TEXT_LABEL = "Once your Vision Board is ready, Click Play";
    public static final String TUTORIAL_TEXT_LABEL = "Watch the Tutorial";
    public static Color GUIDE_TEXT_LABELS_COLOR = new Color(107, 107, 107);
    public static Color TUTORIAL_LABELS_COLOR = new Color(21, 146, 208);

    public static final Color MAIN_PANEL_COLOR = Color.WHITE;

    public static final Color ZERO_COLOR = new Color(0,0,0,0);
    public static final Color MAIN_CONTENT_PANELS_COLOR = MAIN_PANEL_COLOR;
    public static final Color SCROLLBAR_THUMB_COLOR = MAIN_CONTENT_PANELS_COLOR;
    public static final Color NESTED_CONTENT_PANELS_COLOR = Color.white;
    public static final Color CATEGORIES_COLOR = new Color(192,192,192);

    /**
     * URL for tutorial on PanelVisionBoard.
     */
    public static final String TUTORIAL_URL = "https://www.youtube.com/watch?v=MBQdDQnitXs";

    /**
     * URL for JSON settings.
     */
    public static final String SETTINGS_JSON = "http://optafy.com:8080/mindcastr_settings.json";

    //update notifier
    public static final int UPDATE_WIN_WIDTH = 600;
    public static final int UPDATE_WIN_HEIGHT = 191;
    public static final String EMPTY_STRING = "";
    public static final String SERVER_VERSION = "serverVersion";
    public static final String DOWNLOAD_LINK = "downloadLink";

    // autoUpdater
    public static final boolean isWindows = (System.getProperty("os.name").contains("Windows"));
    public static final String osType = (isWindows) ? "win" : "mac";
    public static final String APPNAME = (isWindows) ? "MindCastr.exe" : "MindCastr.jar";
    public static final String DIRTMP = getJarFilePath() + "/tmp/";

    /**
     * URL for registration file.
     */
    public static final String REG_FILE = getMindCastrFolder() + File.separator +
            "Configuration" + File.separator + ".member.rg";
    /**
     * URL for Server.
     */
    public static final String SERVER_URL = "http://optafy.com:5000/";
    //left panel
    public static final int LEFT_PANEL_WIDTH = 120;
    public static final int LEFT_PANEL_HEIGHT = MAIN_WIN_HEIGHT - SHADOW_SIZE * 2;
    public static final Color LEFT_PANEL_BACKGROUND = new Color(248, 248, 255);
    public static final int GAP_SIZE = 2;

    //login window
    public static final int LOGIN_WINDOW_WIDTH = 700;
    public static final int LOGIN_WINDOW_HEIGHT = 650;
    public static final int LOGIN_WINDOW_GAP_SIZE = 20;
    public static final int LOGIN_WINDOW_SHADOW_SIZE = 35;

}
