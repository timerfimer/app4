package com.example.app4
import android.os.Parcel
import android.os.Parcelable
data class AnimalModel(val name: String, val description: String, val imageResource: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(imageResource)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AnimalModel> {
        override fun createFromParcel(parcel: Parcel): AnimalModel {
            return AnimalModel(parcel)
        }

        override fun newArray(size: Int): Array<AnimalModel?> {
            return arrayOfNulls(size)
        }
    }
}
