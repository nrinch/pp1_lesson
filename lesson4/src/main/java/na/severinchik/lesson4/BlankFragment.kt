package na.severinchik.lesson4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


val String.Companion.EMPTY
    get() = ""

val String.Companion.ERROR
    get() = "This value we not receive"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {


    // TODO: Rename and change types of parameters
    private val param1: String by lazy { arguments?.getString(ARG_PARAM1) ?: String.ERROR }
    private val param2: User by lazy { arguments?.getParcelable(ARG_PARAM2) ?: User.DEFAULT }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val textViewFirstParam: TextView = view.findViewById(R.id.fb_first_param)
        val textViewSecondParam: TextView = view.findViewById(R.id.fb_second_param)

        textViewFirstParam.text = param1
        textViewSecondParam.text = param2.toString()
        return view
    }

    companion object {

        val TAG: String = BlankFragment.javaClass.toString()

        fun getInstance(fragmentManager: FragmentManager): BlankFragment =
            fragmentManager.findFragmentByTag(TAG) as BlankFragment ?: BlankFragment()


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: User) =
            BlankFragment().apply {
                arguments = bundleOf(
                    ARG_PARAM1 to param1,
                    ARG_PARAM2 to param2
                )
            }
    }
}

