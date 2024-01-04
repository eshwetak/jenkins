def call(ip, user, credId, warFile) {
    sshagent([credId]) {
      sh "scp -o StrictHostKeyChecking=no target/${warFile} ${user}@${ip}:/opt/tomcat9/webapps/"
      sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ${user}r@${ip} /opt/tomcat9/bin/startup.sh"
    }
}
