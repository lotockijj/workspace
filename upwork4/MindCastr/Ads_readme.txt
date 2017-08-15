Test Case 1. 

Preconditions:
User don't have connection to the Internet or no response from server

Steps:
1.Run application 
2.Observe Main screen
3.Then click on 'Settings' button

Expected result: User shouldn't see the Advertisement on Main and Settings screens

Test Case 2.

Preconditions:
User have connect to the Internet and have respons from server

Steps:
1.Run application 
2.Observe Main screen
--> User should see the Advertisement (Ads) on the bottom in left corner of the screen
3.Click on the Ads

Expected result: Ads link should be opened in the browser.

4. Then click on 'Settings' button
--> The small Ads should be removed and User should see the Ads on the right side of the screen. 
5.Click on the Ads

Expected result:  Ads link should be opened in the browser.

Test Case 3

Preconditions:

1.User run application with connect to the Internet and respons from server
2.Close Application
3. Open Aplication second time, but withount connection to the Internet or without response from server

Steps:
1.Run application 
2.Observe Main screen
--> User should see the Ads (from cache) on the bottom in left corner of the screen
3.Click on the Ads

Expected result:  Ads link (from cache) should be opened in the browser.

4. Then click on 'Settings' button
--> The small Ads should be removed and User should see the Ads (from cache) on the right side of the screen. 
5.Click on the Ads

Expected result:  Ads link (from cache) should be opened in the browser.


Test Case 4

Preconditions:
User don't have connection to the Internet or no response from server

Steps:
1.Run application 
2.Observe Main screen
3.Then click on 'Settings' button

Expected result: User shouldn't see the Advertisement on Main and Settings screens

4.Connection to the Internet appeared with response from server (during running application)
5.Wait a minute

Expected result: Ads appear on Main and Settings screens and user can click on them them. 
After clicking on the Ads, appropriate link should be opened in the browser.