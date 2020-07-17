/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar(){
    if(document.formulario.nombre.value==""||document.formulario.appat.value==""||document.formulario.apmat.value==""||document.formulario.edad.value==""||document.formulario.email.value==""){
        alert("falta de llenar un campo");
        return false;
        
    }else{
        return submit;
    }
}

function validarN(e){//numeros
    var tecla = document.all ? tecla = e.keyCode : tecla = e.wich;
    return ((tecla > 47 && tecla < 58) || tecla == 8);
}

function validarL(e){//letras
    var tecla = document.all ? tecla = e.keyCode : tecla = e.wich;
    var especiales = [0,32,13];
    
    for(var i in espeaciales){
        if(ecla == especiales[i]){
            return true;
        }
        return (((tecla >96 && tecla <123) || (tecla >64 && tecla <91)) || tecla==8);
    }
   }
    //colocar su propia funcion de correo
    function validarC(e){
        
    }

