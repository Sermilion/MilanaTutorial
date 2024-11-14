import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {

    fun onLoginClick() {
        viewModelScope.launch {
        }
    }

    fun onSignUpClick() {
        viewModelScope.launch {
        }
    }

    fun onSkipClick() {
        viewModelScope.launch {
        }
    }
}
