//
// Created by allo cai on 2022/1/2.
//

#include "GLNativeRenderProc.h"

GLint program;
float vertexBuffer[3] = {0.f,0.f,0.f};
auto gFragmentShader =
        """#version 300 es\n"
        "precision mediump float;\n"
        "out vec4 fragColor;\n"
        "void main() {\n"
        "    fragColor = vec4(1.0,0.0,0.0,1.0);\n"
        "}""";

auto gVertexShader =
        """#version 300 es\n"
        "layout(location = 0) in vec4 av_Position;\n"
        "void main() {\n"
        "    gl_Position = av_Position;\n"
        "    gl_PointSize = 10.0;\n"
        "}""";

void InitGLProgram() {
    GLint fileSize = 0;
    // 为了保证两端兼容，不应该下发文件地址，而是先转成字符串
    unsigned char* sampler_vertex = loadFileContent("sampler_vertex.glsl",fileSize);
    unsigned char* sampler_fragment = loadFileContent("sampler_fragment.glsl",fileSize);
    program = createProgram((char*)sampler_vertex,(char*)sampler_fragment);
}

void loadGLProgram(const char * vertexCode,const char * fragmentCode) {
   program = createProgram(vertexCode,fragmentCode);

}

void SetViewPortSize(float width,float height) {
    glViewport(0,0,width,height);
}
void renderImpl() {
    glClear(GL_COLOR_BUFFER_BIT);
    glUseProgram(program);
    glEnableVertexAttribArray(0);
    glVertexAttribPointer(0,3,GL_FLOAT,GL_FALSE,0,vertexBuffer);
    glDrawArrays(GL_POINTS,0,1);
    glDisableVertexAttribArray(0);

}
