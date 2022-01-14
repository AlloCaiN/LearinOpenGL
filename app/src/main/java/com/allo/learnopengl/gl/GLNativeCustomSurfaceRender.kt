package com.allo.learnopengl.gl

import android.content.Context
import com.allo.glnativerender.GLNativeRender
import com.allo.learnopengl.R
import com.allo.learnopengl.gl.env.GLThread

class GLNativeCustomSurfaceRender {
    private val glThread: GLThread = GLThread(hashCode())

    fun initProgram(context : Context) {
        context.let {
            val vertexCode = ShaderUtils.loadFromRawFile(R.raw.sample_vertex,context.resources)?:return
            val fragmentCode = ShaderUtils.loadFromRawFile(R.raw.sample_fragment,context.resources)?:return
            GLNativeRender.loadGLProgram(vertexCode,fragmentCode)
        }
    }
    fun bindSurface(surface : Any) {
        glThread.bindSurface(surface)
    }

    fun queue(callback : () -> Unit) {
        glThread.queue {
            callback.invoke()
        }
    }

     fun onSurfaceChanged(width: Int, height: Int) {
        GLNativeRender.onViewportChanged(width.toFloat(),height.toFloat())
    }

     fun onDrawFrame() {
         GLNativeRender.OnDraw()
         glThread.renderImpl()
    }


}