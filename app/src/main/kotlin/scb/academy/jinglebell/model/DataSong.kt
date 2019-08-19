package scb.academy.jinglebell.model

import android.os.Parcel
import android.os.Parcelable

class DataSong (val nameSong: String,val albums: String,val date: String,val genre: String,val trackPrice: String,val priceCol: String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nameSong)
        parcel.writeString(albums)
        parcel.writeString(date)
        parcel.writeString(genre)
        parcel.writeString(trackPrice)
        parcel.writeString(priceCol)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataSong> {
        override fun createFromParcel(parcel: Parcel): DataSong {
            return DataSong(parcel)
        }

        override fun newArray(size: Int): Array<DataSong?> {
            return arrayOfNulls(size)
        }
    }
}