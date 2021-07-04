plugins{
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.serialization") version "1.5.20"
    id("maven-publish")
}

//Подключает проект с всякими dependency и прочим
evaluationDependsOn("plu")

group = "pluginloader"
version = "1.0.0"

repositories{
    //Репозиторий всех pluginloader:...
    maven{url = uri("https://repo.implario.dev/public")}
}

//Подключает плагин configs
plu("configs")
//plu("plu1", "plu2", etc)

dependencies{

}

fun plu(vararg plugins: String){
    plugins.forEach{project.dependencies.add("dependency", "pluginloader:${if(!it.contains(':')) "$it:1.0.0" else it}")}
}