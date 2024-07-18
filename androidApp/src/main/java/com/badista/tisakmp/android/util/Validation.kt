package com.badista.tisakmp.android.util

object Validation {

    fun validateLogin(userName: String, password: String): Boolean {
        return userName.isNotEmpty() && password.isNotEmpty()
    }

    fun checkValidName(value: String): Pair<String?, Boolean>  {
        if(value.isEmpty()){
            return Pair("Nama tidak boleh kosong", false)
        }
        if(value.length < 3){
            return Pair("Nama minimal 3 karakter", false)
        }
        return Pair(null, true)
    }

    fun checkValidPhone(value: String): Pair<String?, Boolean>  {
        if(value.isEmpty()){
            return Pair("Nomor telepon tidak boleh kosong", false)
        }
        if(value.length < 9){
            return Pair("Nomor telepon minimal 9 karakter", false)
        }
        if (value.length > 14){
            return Pair("Nomor telepon maximal 14 karakter", false)
        }
        if(value[0] != '0' || value[1] != '8'){
            return Pair("Pastikan nomor telepon sesuai", false)
        }
        return Pair(null, true)
    }

    fun checkValidPostalCode(value: String): Pair<String?, Boolean>  {
        if(value.isEmpty()){
            return Pair("Kode Pos tidak boleh kosong", false)
        }
        if(value.length < 3){
            return Pair("Kode Pos minimal 3 karakter", false)
        }
        return Pair(null, true)
    }

    fun checkValidAddress(value: String): Pair<String?, Boolean>  {
        if(value.isEmpty()){
            return Pair("Alamat tidak boleh kosong", false)
        }
        if(value.length < 10){
            return Pair("Alamat minimal 10 karakter", false)
        }
        return Pair(null, true)
    }
}