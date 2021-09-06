package jdbcTutorial.danVega

interface IDAO<T> {
    fun findAll(): List<T>
    fun findById(id: Int): T?
    fun create(entity: T): Boolean
    fun update(entity: T, entity_id: Int): Boolean
    fun delete(entityId: Int): Boolean
}