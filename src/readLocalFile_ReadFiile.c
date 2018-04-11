#include "readLocalFile_ReadFiile.h"
#include <stdio.h>
#include <stdlib.h>

JNIEXPORT jint JNICALL Java_readLocalFile_ReadFiile_getOOM
  (JNIEnv *env, jobject obj, jstring jstr){
	  char* filePath = jstringToChar(env, jstr);
	  
  }
  
  char** readFile(char *filePath){ 
	 FILE *file;  
	 int pos, temp, i; 
	 char ** lines = 

	 //打开文件  
	 file = fopen(filename, "r");  
	 if( NULL == file )  
	 {  
	  fprintf(stderr, "open %s error\n", filename);  
	  return -1;  
	 }

	 pos = 0;  
	 //循环读取文件中的内容  
	 for(i=0; i<MAXLEN-1; i++)  
	 {  
	  temp = fgetc(file);  
	  if( EOF == temp )  
	   break;  
	  dest[pos++] = temp;  
	 }  
	 //关闭文件
	 fclose(file);
	 //在数组末尾加0  
	 dest[pos] = 0; 

	 return pos;  	  
  }
  
  char* jstringToChar(JNIEnv* env, jstring jstr) {
    char* rtn = NULL;
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("GB2312");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte* ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char*) malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    return rtn;
}

jstring charTojstring(JNIEnv* env, const char* pat) {
    //定义java String类 strClass
    jclass strClass = (env)->FindClass("Ljava/lang/String;");
    //获取String(byte[],String)的构造器,用于将本地byte[]数组转换为一个新String
    jmethodID ctorID = (env)->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");
    //建立byte数组
    jbyteArray bytes = (env)->NewByteArray(strlen(pat));
    //将char* 转换为byte数组
    (env)->SetByteArrayRegion(bytes, 0, strlen(pat), (jbyte*) pat);
    // 设置String, 保存语言类型,用于byte数组转换至String时的参数
    jstring encoding = (env)->NewStringUTF("GB2312");
    //将byte数组转换为java String,并输出
    return (jstring) (env)->NewObject(strClass, ctorID, bytes, encoding);
}