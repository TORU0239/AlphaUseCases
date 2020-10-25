package sg.toru.alphausecases.startup

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey

class DataStoreManager(context: Context) {
    private val dataStore = context.createDataStore(
        name = "datastore"
    )

    private object PreferencesKeys {
        val SHOW_COMPLETED = preferencesKey<Boolean>("show_completed")
    }

    suspend fun updateShowCompleted(isShowCompleted:Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SHOW_COMPLETED] = isShowCompleted
        }
    }

    
}