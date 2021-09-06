package jdbcTutorial.danVega

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

    @Autowired
    lateinit var animalDAO: AnimalDAO

    @Bean
    fun init() {
        println("\nAll animals: ----------------------------\n")
        var animals = animalDAO.findAll()
        animals.forEach { println(it) }

        println("\nAll animals after a hawk visit: ----------------------------\n")
        animalDAO.create(Animal(name = "Hawk", habitat = "Sky"))
        animals = animalDAO.findAll()
        animals.forEach { println(it) }

        println("\nFound me: ----------------------------\n")
        println(animalDAO.findById(5))

        println("\nMove to the zoo: ----------------------------\n")
        val lion = animalDAO.findById(2)
        lion!!.habitat = "Zoo"
        animalDAO.update(lion, 2)
        println(animalDAO.findById(2))

        println("\nReally move out: ----------------------------\n")
        animalDAO.delete(2)
        animals = animalDAO.findAll()
        animals.forEach { println(it) }

    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}


