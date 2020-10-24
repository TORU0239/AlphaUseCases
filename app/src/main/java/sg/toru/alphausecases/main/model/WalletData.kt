package sg.toru.alphausecases.main.model


data class TransactionHistory(
    val id:Int,
    val transactionType:String,
    val transactionOutletName:String,
    val transactionAmount:Float
)


data class InfoNearby(
    val id:Int,
    val title:String
)


data class Wallet(
    val nearInfo:List<InfoNearby>,
    val transactionHistory:List<TransactionHistory>
)