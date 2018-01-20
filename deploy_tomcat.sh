sudo mv dist/ProjectHub2.war /var/lib/tomcat8/webapps/ProjectHub2.war
echo "Doing deployment prior configuration..."
echo "\nCleaning builds at /var/lib/tomcat8/webapps"
echo "\nGenerating tomcat prebuilds on /var/lib/tomcat8/webapps..."
echo "\nDeploying on felix platform oracle.jvm.platforms.felix.Felix..."
echo "\nRunning tomcat middleware on Felix..."
google-chrome http://localhost:8080/ProjectHub2/Main

