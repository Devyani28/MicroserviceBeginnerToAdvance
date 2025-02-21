from openjdk:17
EXPOSE 8095
ADD target/testDockerWithoutDb-0.0.1-SNAPSHOT.jar JarNameFromLocalToDockerServer
ENTRYPOINT ["java","-jar","/JarNameFromLocalToDockerServer"]