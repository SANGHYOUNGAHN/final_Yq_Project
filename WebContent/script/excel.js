function checkForm() {   
 if (upload.file1.value == "") {   
  alert("파일을 업로드해주세요.");   
  return false;   
 }  else if(!checkFileType(upload.file1.value)) {   
  alert("엑셀파일만 업로드 해주세요.");   
  return false;   
 }   
  document.upload.submit();
}   
function checkFileType(filePath){   
  
 var fileLen = filePath.length;   
 var fileFormat = filePath.substring(fileLen - 4);   
 fileFormatfileFormat = fileFormat.toLowerCase();   
  
 if (fileFormat == ".xls"){   return true;    
 }   else{     return false;     }   
}   