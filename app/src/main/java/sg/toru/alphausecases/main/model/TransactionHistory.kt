package sg.toru.alphausecases.main.model

data class TransactionHistory(
    val id:Int,
    val transactionType:String,
    val transactionOutletName:String,
    val transactionAmount:Float
)