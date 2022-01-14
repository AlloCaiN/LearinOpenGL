package com.allo.learnopengl

import android.opengl.GLSurfaceView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.allo.learnopengl.gl.GLNativeSurfaceRender
import com.allo.learnopengl.gl.GLSurfaceRender


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = GLSurfaceView(this)
        // 需要配置环境
        view.setEGLContextClientVersion(3)
        view.setRenderer(GLSurfaceRender(this))
        setContentView(view)
    }
}