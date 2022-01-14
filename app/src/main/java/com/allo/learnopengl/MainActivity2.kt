package com.allo.learnopengl

import android.app.Activity
import android.content.Intent
import android.graphics.SurfaceTexture
import android.os.Bundle
import android.view.TextureView
import android.widget.Button
import com.allo.learnopengl.gl.GLCustomSurfaceRender

class MainActivity2: Activity() {
    val render = GLCustomSurfaceRender()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.launcher).setOnClickListener {
            startActivity(Intent()?.apply {
                this.setClassName(this@MainActivity2.applicationContext,"com.allo.learnopengl.GLActivity3")
            })
        }

    }
}