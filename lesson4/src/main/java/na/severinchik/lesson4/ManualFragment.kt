package na.severinchik.lesson4

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.parcelize.Parcelize
import na.severinchik.lesson4.ui.MainBottomDialogFragment

class ManualFragment : Fragment() {

    companion object {
        val TAG = ManualFragment::javaClass.toString()
    }

    val arg: ManualFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_manual, container, false)

        val button: Button = view.findViewById(R.id.fm_go_to_another_fragment)

        button.text = arg.name
        button.setOnClickListener { goToBlankFragment() }

        return view
    }

    private fun goToBlankFragment() {
        val fragmnetManager = requireActivity().supportFragmentManager
        parentFragmentManager.beginTransaction()
            .add(MainActivity.fragmentContaier, BlankFragment.newInstance(arg1, arg2))
            .addToBackStack(TAG)
            .commit()

        MainBottomDialogFragment().show(parentFragmentManager,"")
    }
}


@Parcelize
data class User(val name: String, val surname: String, val age: Int) : Parcelable {
    companion object {
        val DEFAULT = User(String.EMPTY, String.EMPTY, -1)
    }
}


private const val arg1: String = "John"
private val arg2: User = User("John", "Doe", 42)


