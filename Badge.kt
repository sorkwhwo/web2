package org.techtown.app_project

class Badge {
    @JvmField
    var percent: String
    @JvmField
    var name: String? = null
    @JvmField
    var img: Int

    internal constructor(percent: String, img: Int) {
        this.percent = percent
        this.img = img
    }

    internal constructor(percent: String, img: Int, name: String?) {
        this.percent = percent
        this.img = img
        this.name = name
    }
}