package com.allo.learnopengl

import android.graphics.SurfaceTexture
import android.os.Bundle
import android.view.TextureView
import androidx.appcompat.app.AppCompatActivity
import com.allo.learnopengl.gl.GLNativeCustomSurfaceRender

class GLActivity3: AppCompatActivity() {
    val render = GLNativeCustomSurfaceRender()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view: TextureView = TextureView(this)
        setContentView(view)
        // 需要配置环境
        // view.setEGLContextClientVersion(3)
        view.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
            override fun onSurfaceTextureAvailable(
                surface: SurfaceTexture,
                width: Int,
                height: Int
            ) {
                render.queue {
                    render.bindSurface(surface)
                    render.initProgram(baseContext)
                    render.onSurfaceChanged(width, height)
                    render.onDrawFrame()
                }
            }

            override fun onSurfaceTextureSizeChanged(
                surface: SurfaceTexture,
                width: Int,
                height: Int
            ) {

            }

            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
                return false
            }

            override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {

            }
        }
    }

}