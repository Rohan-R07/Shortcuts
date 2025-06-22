# 🔗 Android App Shortcuts Demo

This is a simple Android application that demonstrates the implementation of both **static** and **dynamic app shortcuts**. It is meant for practicing and understanding how Android shortcuts work, and how to create and manage them programmatically.

---

## ✨ Features

- 📌 **Three total app shortcuts**
  - Two **static shortcuts** declared in the manifest
  - One **dynamic shortcut** created at runtime
- ✍️ Users can **customize the name** of the dynamic shortcut using an `TextField` inside the app
- 🚀 Quick access to specific parts of the app directly from the launcher
- 🧠 Basic use of `ViewModel` to handle configuration changes

---

## 🎯 Purpose

This app is intended as a **demo or learning project** to:
- Understand Android’s `ShortcutManager` API
- Learn how to create dynamic shortcuts based on user input
- Practice managing app shortcuts with clean and simple code

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Architecture:** ViewModel (for basic state management)
- **Android APIs Used:**
  - `ShortcutManager`
  - `ShortcutInfo`
  - `ShortcutIntentBuilder` (if applicable)

---

## 🧪 How to Use

1. Install the APK and open the app
2. Use the `TextField` field to set a name for the dynamic shortcut
3. Press the action button (if any) to apply it
4. Long press the app icon on your launcher to see the shortcuts

---


## 📱 Screenshots for Referance


This is how shortcut looks like before name it or in the home 


![Screenshot 2025-06-22 183153](https://github.com/user-attachments/assets/ec86f8b4-fc9d-436f-988d-648f2b45e0bd)



main screen of the application 



![Screenshot 2025-06-22 190142](https://github.com/user-attachments/assets/0f3403a3-b1d6-493e-a148-36887b4b1644)





After clicking the button "Press to open Second Screen" this screen will be displayed




![Screenshot 2025-06-22 190542](https://github.com/user-attachments/assets/a9f16ecc-c80e-4b37-9ee6-d4081f13c943)



Naming the Shortcut



![Screenshot 2025-06-22 190730](https://github.com/user-attachments/assets/b3ed731d-1e3f-4423-8c6e-04ca96b89bc1)



As soon as you click the button "Create Shortcut:)" You will get to see you custom named shortcut 




![Screenshot 2025-06-22 190906](https://github.com/user-attachments/assets/5da84757-5732-42b5-86bd-683c5164e758)



---





## 📦 APK

You can find the latest APK in the [Releases](../../releases) section.

---

## 📚 References

- [Official Android ShortcutManager Docs](https://developer.android.com/reference/android/content/pm/ShortcutManager)
- [App Shortcuts Overview](https://developer.android.com/guide/topics/ui/shortcuts)

---

> ⚠️ Note: Requires **Android 7.1 (API 25)** or above to use shortcuts.

