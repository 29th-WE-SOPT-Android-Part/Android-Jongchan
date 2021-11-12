# week4

---

### Gif

![](../../../../../../Downloads/soptweek4.gif)

---

### Postman - 회원가입 완료

![](../../../../../postman_signup.png)

---

### Postman - 로그인 완료

![](../../../../../postman_login.png)

---

### RequestLoginData

- request에 필요한 data 형식

~~~kotlin
data class RequestLoginData(
    @SerializedName("email")
    val id: String,
    val password: String,
)
~~~

---

### ResponseLoginData

- response 받을 때 필요한 data 형식

~~~kotlin
data class ResponseLoginData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        val id: Int,
        val name: String,
        val email: String,
    )
}
~~~

---

### RequestSignupData

~~~kotlin

data class RequestSignupData(
    @SerializedName("email")
    val id: String,
    val name: String,
    val password: String,
)

~~~

---

### ResponseSignupData

~~~kotlin
data class ResponseSignupData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        val id: Int,
        val name: String,
        val email: String,
    )
}

~~~

---

### SampleService, SignupService

- Headers와, POST에 필요한 값을 넣어주고 postLogin, postSignup을 통해 요청 및 응답을 받는다.

~~~kotlin
interface SampleService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postLogin(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>
}
~~~

~~~kotlin
interface SignupService {
    @Headers("Content-Type:application/json")
    @POST("user/signup")
    fun postSignup(
        @Body body: RequestSignupData
    ): Call<ResponseSignupData>
}
~~~

---

### ServiceCreator

- baseurl 설정 이후 retrofit 객체 생성

~~~kotlin
object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

    // Retrofit 객체 생성
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val sampleService: SampleService = retrofit.create(SampleService::class.java)
    val signupService: SignupService = retrofit.create(SignupService::class.java)
}
~~~

### SignInActivity.initNetWork()

- call 객체를 받은 다음 비동기적 서버 통신 연결 이후 응답코드가 200~300인 경우 if문 실행, 
그렇지않은 경우 else문을 실행하게 된다.

~~~kotlin
 private fun initNetWork() {
    val requestLoginData = RequestLoginData(
        binding.idEditText.text.toString(),
        binding.pwEditText.text.toString()
    )
    val call: Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)
    call.enqueue(object : retrofit2.Callback<ResponseLoginData> {
        override fun onResponse(call: Call<ResponseLoginData>, response: Response<ResponseLoginData>) {
            if (response.isSuccessful) {
                val data = response.body()?.data
                Toast.makeText(this@SignInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
            } else {
                Toast.makeText(this@SignInActivity, "Login_Fail", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
            Log.e("Network_Test", "error : $t")
        }
    })
}
~~~

### 배운 것

- postman 사용법
- retrofit 이용해서 서버 통신하는법
- github 연동하다가 실패... 과제제출 이후 다시하는 걸로

### 느낀점

점점 어려워지는게 몸소 체감이 된다 이전에 했던 과제를 좀 더 완성도 있게 할 수 있어야 이후에
과제를 할 수 있을거 같다.


