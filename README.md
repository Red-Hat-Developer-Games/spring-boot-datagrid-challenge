# DEVELOPER GAMES
# CORE DREAM TEAM
# DATAGRID Spring BOOT (Challenge #03)
##
Project fork:  
https://github.com/artudf/spring-boot-datagrid-challenge
Openshift URL:  
https://spring-boot-datagrid-challenge-user2-challenge3.apps.cluster-kc2df.kc2df.sandbox790.opentlc.com
Infinispan Console:  (user01/User01)  
http://rhdg-external-user2-challenge3.apps.cluster-kc2df.kc2df.sandbox790.opentlc.com/console/

*Note*
Created script to remote call to OCP deploy of the application
**weatherFetcherOCP.sh**

## Added DataGrid Cache elements and control of nulls  
   @Cacheable(value="weather",key="#location", unless="#result==null" )  

## Added Spring Session Cache (Default user add in Security configuration)
@EnableCaching
@EnableInfinispanRemoteHttpSession
@Configuration
public class InfinispanConfiguration {

     @Bean
     public SpringRemoteCacheManagerFactoryBean springCache() {
         return new SpringRemoteCacheManagerFactoryBean();
     }

