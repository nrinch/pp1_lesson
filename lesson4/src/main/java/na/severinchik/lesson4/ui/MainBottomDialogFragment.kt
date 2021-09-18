package na.severinchik.lesson4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import na.severinchik.lesson4.databinding.FragmentDialogMainBottomBinding

class MainBottomDialogFragment:DialogFragment() {

    lateinit var binding: FragmentDialogMainBottomBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogMainBottomBinding.inflate(inflater,container,false)

        binding.fdmbOk.setOnClickListener {
            dismiss()
        }

        return binding.root
    }
}