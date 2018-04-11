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

	 //���ļ�  
	 file = fopen(filename, "r");  
	 if( NULL == file )  
	 {  
	  fprintf(stderr, "open %s error\n", filename);  
	  return -1;  
	 }

	 pos = 0;  
	 //ѭ����ȡ�ļ��е�����  
	 for(i=0; i<MAXLEN-1; i++)  
	 {  
	  temp = fgetc(file);  
	  if( EOF == temp )  
	   break;  
	  dest[pos++] = temp;  
	 }  
	 //�ر��ļ�
	 fclose(file);
	 //������ĩβ��0  
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
    //����java String�� strClass
    jclass strClass = (env)->FindClass("Ljava/lang/String;");
    //��ȡString(byte[],String)�Ĺ�����,���ڽ�����byte[]����ת��Ϊһ����String
    jmethodID ctorID = (env)->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");
    //����byte����
    jbyteArray bytes = (env)->NewByteArray(strlen(pat));
    //��char* ת��Ϊbyte����
    (env)->SetByteArrayRegion(bytes, 0, strlen(pat), (jbyte*) pat);
    // ����String, ������������,����byte����ת����Stringʱ�Ĳ���
    jstring encoding = (env)->NewStringUTF("GB2312");
    //��byte����ת��Ϊjava String,�����
    return (jstring) (env)->NewObject(strClass, ctorID, bytes, encoding);
}