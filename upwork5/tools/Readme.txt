Procedure how prepare installers and updates for Windows and Mac

1. Create an EXE file for Windows (only works on Windows)
1.1 Install Inno Setup 5. Download it from http://www.jrsoftware.org/isdl.php
1.2 Run Ant target name "make-installer-win"

2. Create a DMG package for MacOS X (only works on MacOS X)
2.1 Run Ant target name "make-dmg"

3. Prepare updates
3.1 Run Ant target name "make-upd-mac" to make update zip for MacOS X (works on MacOS X and Windows)
3.2 Run Ant target name "make-upd-win" to make update zip for Windows (only works on Windows)

4. All files will be placed in "releases/" directory
- "MindCastr_setup.exe" for Windows
- "MindCastr_install.dmg" for MacOS X 
- "update_win.zip" for Windows
- "update_mac.zip" for MacOS X 

5. Move files to the web server

6. In file "mindcastr_settings.json" check version and urls for updating
        "version": "1.0",
        "update_files": {
            "win": "http://mindcastr.com/update_win.zip",
            "mac": "http://mindcastr.com/update_mac.zip"
        }

Thanks!
