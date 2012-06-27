mvn clean package
cp target/online-addressbook.war /usr/local/apache-tomcat-6.0.35/webapps/
cd /usr/local/apache-tomcat-6.0.35
rm -r webapps/online-addressbook
./bin/shutdown.sh
./bin/startup.sh
