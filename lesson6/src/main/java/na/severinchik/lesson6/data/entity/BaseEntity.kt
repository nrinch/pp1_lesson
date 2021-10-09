package na.severinchik.lesson6.data.entity

import android.app.Activity

interface BaseEntity {
    var id: Long
    val contentDescription: String
}


data class CatEntity(
    override var id: Long,
    override val contentDescription: String
) : BaseEntity


interface Saver{
    fun save()
}

fun Activity.saveAndFinish(saver:Saver){
    saver.save()
    finish()
}