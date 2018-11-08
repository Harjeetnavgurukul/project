package assure.mw.com.interfaces

interface LoginInputValidationCallback {

    fun onSuccess(s: String)
    fun onError(s: String)
}