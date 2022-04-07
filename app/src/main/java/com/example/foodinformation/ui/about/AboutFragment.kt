package com.example.foodinformation.ui.about

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.foodinformation.databinding.FragmentAboutBinding
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.foodinformation.R


class AboutFragment : Fragment() {



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentAboutBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.openSiteText.setOnClickListener {
            showAlertDialog()
        }

        return binding.root
    }

    private fun showAlertDialog() {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.yes,
                    DialogInterface.OnClickListener { dialog, id ->
                        openUrl()
                    })
                setNegativeButton(R.string.no,
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })
            }
            builder.create()
        }
        alertDialog?.setMessage(getString(R.string.open_site))
        alertDialog?.create()
        alertDialog?.show()
    }


    private fun openUrl() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.site_company_url)))
        startActivity(browserIntent)
    }
}