package jdbcTutorial.danVega

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component

@Component
class AnimalDAO : IDAO<Animal> {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    private var rowMapper = RowMapper { rs, rowNum ->
        val animal = Animal()
        animal.id = rs.getInt("id")
        animal.name = rs.getString("name")
        animal.habitat = rs.getString("habitat")
        return@RowMapper animal
    }

    override fun findAll(): List<Animal> {
        val sql = "SELECT * FROM animal"
        return jdbcTemplate.query(sql, rowMapper)
    }

    override fun create(entity: Animal): Boolean {
        val sql = "INSERT INTO animal (name, habitat) values (?,?)"
        val numberOfUpdatedRows = jdbcTemplate.update(sql, entity.name, entity.habitat)
        return numberOfUpdatedRows == 1
    }

    override fun update(entity: Animal, entity_id: Int): Boolean {
        val sql = "UPDATE animal set name = ?, habitat = ? where id = ?"
        return jdbcTemplate.update(sql, entity.name, entity.habitat, entity.id) == 1
    }

    override fun delete(entityId: Int): Boolean {
        val sql = "DELETE from animal where id = ?"
        return jdbcTemplate.update(sql, entityId) == 1
    }

    override fun findById(id: Int): Animal? {
        return jdbcTemplate.queryForObject("SELECT id, name, habitat FROM animal WHERE id = ?", rowMapper, id)
    }
}