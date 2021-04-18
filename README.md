FrameWork User Guide
================================================================================================

Below Improvements to be done in the Framework
================================================================================================
1.Logger implementation
2.Extent Report implementation
3.Improve exception handling
4.Improve Explict waits

Pre-requisites
================================================================================================
1. Java (v16)
2. Appium desktop for windows (v1.20.2)
3. Android SDK (API Level should be compatible with Android version)
	A. https://en.wikipedia.org/wiki/Android_(operating_system)
4. TestNG
5. Maven
6. Android Real Device
7. Eclipse IDE 2021-03


Maven dependencies : (https://mvnrepository.com/)
===============================================================================================
1. TestNG
2. Java-Client
3. Selenium-java
4. Apache POI (to read data from .xlsx) 

Appium Installation via NPM
===============================================================================================

**Step 1** :Check if node.js is installed on your system
			Node --version
			Npm --version
**Step 2**: download Node.js installer
			https://nodejs.org/en/download/
**Step 3** : Run the installer & install node.js & npm
**Step 4** : Check if node.js & npm are installed
			Node --version
			Npm --version
			Where node
			Where npm
**Step 5** : install appium with node.js
			Npm install -g appium (-g represents install globally)
			
**Step 6** : Check if appium is installed
			Appium --version
			Where appium
**Step 7 **: Start appium (By default Appium will start 0.0.0.0:4723)
			        Appium
 		 To start custom address with cutom port no
			appium -a 127.0.0.1 -p 4745
	
		
	If in case of below error while starting appium :
	 Could not start REST http interface listener. The requested port may already be in use. Please make sure there is no other instance of this server running already.
	Fatal Error: listen EADDRINUSE: address already in use 0.0.0.0:4723
	    at Server.setupListenHandle [as _listen2] (net.js:1318:16)
	    at listenInCluster (net.js:1366:12)
	    at doListen (net.js:1503:7)
	    at processTicksAndRejections (internal/process/task_queues.js:81:21)
	
	Solution : try to configure appium with different port 
			appium  --port 4745

Some Useful Commands to KickStart
=========================================================================================================================
Finding device name through command prompt
	>adb devices
	
Finding App Package and App Activity in Windows
=========================================================================================================================
**Step 1:** Unlock your mobile device and connect it to your computer using USB cable
**Step 2:** Open Command Prompt and run ‘adb devices’ command. We are running this command to just make sure that your mobile is properly connected.
**Step 3:** Once you run ‘adb devices’ command, you should see that it displays the list of attached devices as shown in the below image (the actual device name that you see would be different based on what mobile phone you use) – 
**Step 4:** Run ‘adb shell’ command. After running this command, the command prompt should look something like this –
**Step 5:** Now in your mobile phone, open the app for which you want to find the appPackage and appActivity. Since we are doing this for Play Store, hence we will open “Play Store” on our mobile phone.

Note: Please make sure that you open the app before going to the next step, because command in the next step would provide the details only for the app which is currently in focus.
**Step 6:** Now run this command: dumpsys window windows | grep -E ‘mCurrentFocus’

**Step 7:** The above command would display the details of the app which is currently in focus. From that, you can figure out the appPackage and appActivity name as per the below image –
			
			
			
			
			
			
