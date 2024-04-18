// Generated by view binder compiler. Do not edit!
package com.example.quiz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.quiz.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityQuestionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button confirm;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView lblPergunta;

  @NonNull
  public final RadioButton optionA;

  @NonNull
  public final RadioButton optionB;

  @NonNull
  public final RadioButton optionC;

  @NonNull
  public final RadioButton optionD;

  @NonNull
  public final RadioButton optionE;

  @NonNull
  public final RadioGroup radioGroup;

  private ActivityQuestionBinding(@NonNull ConstraintLayout rootView, @NonNull Button confirm,
      @NonNull ImageView imageView, @NonNull TextView lblPergunta, @NonNull RadioButton optionA,
      @NonNull RadioButton optionB, @NonNull RadioButton optionC, @NonNull RadioButton optionD,
      @NonNull RadioButton optionE, @NonNull RadioGroup radioGroup) {
    this.rootView = rootView;
    this.confirm = confirm;
    this.imageView = imageView;
    this.lblPergunta = lblPergunta;
    this.optionA = optionA;
    this.optionB = optionB;
    this.optionC = optionC;
    this.optionD = optionD;
    this.optionE = optionE;
    this.radioGroup = radioGroup;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityQuestionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityQuestionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_question, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityQuestionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.confirm;
      Button confirm = ViewBindings.findChildViewById(rootView, id);
      if (confirm == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.lblPergunta;
      TextView lblPergunta = ViewBindings.findChildViewById(rootView, id);
      if (lblPergunta == null) {
        break missingId;
      }

      id = R.id.optionA;
      RadioButton optionA = ViewBindings.findChildViewById(rootView, id);
      if (optionA == null) {
        break missingId;
      }

      id = R.id.optionB;
      RadioButton optionB = ViewBindings.findChildViewById(rootView, id);
      if (optionB == null) {
        break missingId;
      }

      id = R.id.optionC;
      RadioButton optionC = ViewBindings.findChildViewById(rootView, id);
      if (optionC == null) {
        break missingId;
      }

      id = R.id.optionD;
      RadioButton optionD = ViewBindings.findChildViewById(rootView, id);
      if (optionD == null) {
        break missingId;
      }

      id = R.id.optionE;
      RadioButton optionE = ViewBindings.findChildViewById(rootView, id);
      if (optionE == null) {
        break missingId;
      }

      id = R.id.radioGroup;
      RadioGroup radioGroup = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup == null) {
        break missingId;
      }

      return new ActivityQuestionBinding((ConstraintLayout) rootView, confirm, imageView,
          lblPergunta, optionA, optionB, optionC, optionD, optionE, radioGroup);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
