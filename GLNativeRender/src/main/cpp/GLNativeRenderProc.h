//
// Created by allo cai on 2022/1/2.
//

#ifndef LEARNOPENGL_GLNATIVERENDERPROC_H
#define LEARNOPENGL_GLNATIVERENDERPROC_H
#include "gles.h"
#include "utils/ShaderUtils.h"

void InitGLProgram();
void SetViewPortSize(float width,float height);
void renderImpl();
void loadGLProgram(const char * vertexCode,const char * fragmentCode);

extern "C" JNIEXPORT void JNICALL
Java_com_allo_glnativerender_GLNativeRender_InitOpenGL(JNIEnv *env,jobject type) {
    InitGLProgram();
}

extern "C" JNIEXPORT void JNICALL
Java_com_allo_glnativerender_GLNativeRender_onViewportChanged(JNIEnv *env, jobject type,jfloat width,jfloat height) {
    SetViewPortSize(width,height);
}





#endif //LEARNOPENGL_GLNATIVERENDERPROC_H

extern "C"
JNIEXPORT void JNICALL
Java_com_allo_glnativerender_GLNativeRender_loadGLProgram(JNIEnv *env, jobject thiz,
                                                          jstring vertex_code, jstring fragment) {
    loadGLProgram(reinterpret_cast<const char *>(vertex_code),
                  reinterpret_cast<const char *>(fragment));
}
extern "C"
JNIEXPORT void JNICALL
Java_com_allo_glnativerender_GLNativeRender_OnDraw(JNIEnv *env, jobject thiz) {
    renderImpl();
}