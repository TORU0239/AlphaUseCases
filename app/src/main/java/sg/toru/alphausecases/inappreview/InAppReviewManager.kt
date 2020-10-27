package sg.toru.alphausecases.inappreview

import android.app.Activity
import android.content.Context
import com.google.android.play.core.review.ReviewManagerFactory

class InAppReviewManager {
    fun review(
        context: Context,
        activity: Activity
    ){
        val reviewManager = ReviewManagerFactory.create(context)
        val requestFlow = reviewManager.requestReviewFlow()
        requestFlow.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                val reviewInfo = request.result
                reviewManager.launchReviewFlow(activity, reviewInfo)
            } else {
                // do some stuff if a problem occurs, regardless of the result.
            }
        }
    }
}