
# SPRING SECURITE

## Auteur

👤**Mady CAMARA**

* Email: [🇫🇷 madymadesc@gmail.com](<madymadesc@gmail.com>)
* Github: [@madymadesc](https://github.com/madymadesc)
* LinkedIn: [@Mady Mades](https://www.linkedin.com/in/mady-camara-b12b04114)

#### [Reference "toptal.com"](https://www.toptal.com/spring/spring-security-tutorial)

### Définition

L' authentification fait référence au processus de vérification de l'identité d'un utilisateur, sur la base des informations d'identification fournies. Un exemple courant consiste à entrer un nom d'utilisateur et un mot de passe lorsque vous vous connectez à un site Web. Vous pouvez le considérer comme une réponse à la question Qui êtes-vous ? .

L'autorisation fait référence au processus consistant à déterminer si un utilisateur dispose de l'autorisation appropriée pour effectuer une action particulière ou lire des données particulières, en supposant que l'utilisateur est authentifié avec succès. Vous pouvez le considérer comme une réponse à la question Un utilisateur peut-il faire/lire ceci ? .

Le principe fait référence à l'utilisateur actuellement authentifié.

L'autorité accordée fait référence à l'autorisation de l'utilisateur authentifié.

Le rôle fait référence à un groupe d'autorisations de l'utilisateur authentifié.

### Création d'une application Spring de base

Nous pouvons utiliser un Spring Initializr et générer un modèle de projet. Pour une application web simple, seule une dépendance du framework web Spring suffit :
  
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

Ajoutons un simple contrôleur REST comme suit :

```
@RestController @RequestMapping("hello")
public class HelloRestController {

    @GetMapping("user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

}
```

Après cela, si nous construisons et exécutons le projet, nous pouvons accéder aux URL suivantes dans le navigateur Web :
```
http://localhost:8080/hello/user renverra la chaîne Hello User.
```
```
http://localhost:8080/hello/admin renverra la chaîne Hello Admin.
```
Créons la class security config

```
@EnableWebSecurity
public class SecurityConfig{}
```
Configurons les roles des utilisateur 
```
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/USER").hasRole("USER");
                    auth.requestMatchers("/ADMIN").hasRole(("ADMIN"));
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}

```
Configurons les accès des utilisateur

```
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/USER").hasRole("USER");
                    auth.requestMatchers("/ADMIN").hasRole(("ADMIN"));
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}

```
###  Merci !!!