package sg.toru.alphausecases.startup

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


data class UserPreferences(
    val showCompleted:Boolean,
    val isFirstLaunch:Boolean
)

class DataStoreManager(context: Context) {
    private val dataStore = context.createDataStore(
        name = "datastore"
    )

    private object PreferencesKeys {
        val SHOW_COMPLETED = preferencesKey<Boolean>("show_completed")
        val IS_FIRST_LAUNCH = preferencesKey<Boolean>("is_first_launch")
    }


    val userPreferenceFlow: Flow<UserPreferences> = dataStore.data.catch { exception ->
        if (exception is IOException) {
            Log.e("Toru", "Error reading preferences.", exception)
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        val showCompleted = preferences[PreferencesKeys.SHOW_COMPLETED] ?: false
        val isFirstLaunch = preferences[PreferencesKeys.IS_FIRST_LAUNCH] ?: false
        UserPreferences(showCompleted, isFirstLaunch)
    }

    suspend fun updateShowCompleted(isShowCompleted:Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SHOW_COMPLETED] = isShowCompleted
        }
    }

    suspend fun updateFirstLaunch(firstLaunch:Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_FIRST_LAUNCH] = firstLaunch
        }
    }
}