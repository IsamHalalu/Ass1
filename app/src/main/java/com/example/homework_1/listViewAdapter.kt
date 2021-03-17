package com.example.homework_1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.user.view.*

class listViewAdapter(var activity: Activity, var data: MutableList<userModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return data[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.user, null, false)
        }
        view!!.na.text = data[position].name
        view.em.text = data[position].email

        return view
    }
}