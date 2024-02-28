# splunk-logging-demo
Splunk logging sample code

# Steps to be followed:
1. Download the Splunk installer from the Splunk download page. Link: https://www.splunk.com/en_us/download/splunk-enterprise.html?locale=en_us
2. Double-click the splunk.msi (for ex: splunk-9.1.3-d95b3299fa65-x64-release.msi) file to start the installer.
3. Check License box to accept the License Agreement.
4. Customize options during the installation
5. Click Install to proceed with the installation
6. Change the installation path to C:\Program Files\Splunk
7. Install Splunk Enterprise as the Local System and then click on Next

8. For more about istallation, kindly follow these urls
# URLS:
"https://www.splunk.com/en_us/resources/videos/installing-splunk-on-windows.html"

"https://subscription.packtpub.com/book/data/9781785889462/1/ch01lvl1sec8/installing-splunk-on-windows"

9. Run splunk using windows services(for ex: Splunkd Service)

10. Once splunk service is up, follow below urls for login & acoount setup.
# URLS:
"http://localhost:8000/en-US/account/login?return_to=%2Fen-US%2Fmanager%2Flauncher%2Flogin_page_settings"

"http://localhost:8000/en-US/account/login?return_to=%2Fen-US%2Faccount%2F"

"http://localhost:8000/en-US/account/logout"

11. Run this sample code i.e. splunk-logging-demo
12. Validate the services.

"http://localhost:9090/orders/addOrder"

"http://localhost:9090/orders/getAllOrders"

"http://localhost:9090/orders/getOrder/1"

"http://localhost:9090/orders/getOrder/2"

14. Login to local splunk server and search using keyword index="order_api_dev"
# URL:
"http://localhost:8000/en-US/app/search/search?q=search%20index%3D%22order_api_dev%22&display.page.search.mode=verbose&dispatch.sample_ratio=1&workload_pool=&earliest=-24h%40h&latest=now&sid=1709123044.9"
