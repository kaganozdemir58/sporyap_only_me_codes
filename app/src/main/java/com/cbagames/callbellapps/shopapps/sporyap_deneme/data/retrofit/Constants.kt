package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit

class Constants {

    companion object INSTANCE{
        const val BASE_URL = "https://mobileapitest.sporyap.app/api/"
        const val CONTENT_TYPE_KEY = "Content-Type"
        const val CONTENT_TYPE_VALUE = "application/json;charset=UTF-8"
        const val AUTHORIZATION_KEY = "Authorization"
        const val BEARER_KEY = "Bearer "
        const val ACCEPT ="accept"
        const val API_TOKEN = "CFFB8277C5D14F54B15EC794D0340310"
        const val HEADER_API_KEY = "ApiKey"
        const val ACCOUNT_AUTHENTICATE = "account/authenticate"
        const val ACCOUNT_REGISTER = "account/register"
        const val ACCOUNT_CONFIRM_CODE = "account/confirm-code"
        const val ACCOUNT_SEND_CODE_AGAIN = "account/send-code-again"
        const val ACCOUNT_FORGOT_PASSWORD = "account/forgot-password"
        const val ACCOUNT_RESET_PASSWORD = "account/reset-password"
        const val ACCOUNT_REFRESH_TOKEN = "account/refresh-token"
        const val ACCOUNT_LOG_OUT = "account/logout"
        const val GET_PHONE_CODES = "country/get-all-phone-code"
        const val GET_SPORTS = "sports/get-all"
        const val INSERT_REGION_DETAIL = "other/insert-region-detail"
        const val USER_PROFILE_INFO = "users/profile-infos"
        const val PREF_NAME = "name"
        const val PREF_LAST_NAME = "lastName"
        const val PREF_EMAIL = "email"
        const val PREF_PHONE = "phone"
        const val PREF_PASSWORD = "password"
        const val PREF_GENDER = "gender"
        const val PREF_LAT = "lat"
        const val PREF_LONG = "long"
        const val PREF_CITY = "city"
        const val PREF_COUNTRY = "country"
        const val PREF_SUB_LOCALITY = "sublocality"
        const val QUERY_TOKEN = "Token"
        const val QUERY_USER_ID = "UserId"
        const val QUERY_SPORT_ID = "sporId"
        const val NOTIFICATION_TYPE_ID = "NotificationTypeId"
        const val QUERY_VERIFY_CODE = "VerifyCode"
        const val BUNDLE_CORPORATE_NAME = "corporateName"
        const val BUNDLE_CORPORATE_TYPE = "corporateType"
        const val CORPORATE_TYPES_GET_ALL = "corporate-types/get-all/"
        const val ARG_FOR_WHAT = "forWhat"
        const val ARG_TYPE = "type"
        const val ARG_USER_ID = "userId"
        const val ARG_NOTIFICATION_TYPE_ID = "notificationTypeId"
        const val ARG_USER_TYPE = "userType"
        const val PREF_USER_ID = "userId"
        const val PREF_IS_LOGGED =  "isLogged"
        const val PREF_USER_NAME = "userName"
        const val PREF_TOKEN = "token"
        const val ERROR_MESSAGE = "Error"
        const val SPLASH_DELAY = 3000L
        const val ATHLETE_SPORTS = "athleteSports"
        const val TRAINER_SPORTS = "trainerSports"
        const val CORPORATE_SPORTS = "corporateSports"
        const val GET_ALL_EVENT_TYPES = "events/get-all-event-type"
        const val GET_ALL_GENDER_TYPES = "other/get-all-gender-types"
        const val GET_ALL_EVENT_CATEGORIES = "events/get-all-event-category"
        const val GET_ALL_EVENT_OWNER_TYPES = "events/get-all-event-owner-types"
        const val GET_SPORTS_BY_PAGES = "sports/list-by-pages"
        const val PAGE = "page"
        const val PAGE_SIZE = "pageSize"
        const val INTRO_VIDEO_URL = "https://sporyap.app/photos/giris_modulu/intro_video/intro.mp4"
        const val DATE_FORMAT = "dd.MM.yyyy"
        const val TIME_FORMAT = "HH:mm"
        const val USER_TYPE = "userType"
        const val SPORT_ID_LIST = "sportIdList"
    }
}