package com.example.sandbox


class MyThread: Runnable {

    override fun run() {

    }

    //           draw          draw                             UI Thread
    // ----------16ms----------16ms-------------16ms----------> Time  60 hZ


    /*  Thread 1           Thread 2
     * print            |
     * doOperation      |
     * async(callback) -> | work(callback)
     * doOperation1     |
     * doOperation2     |
     * doOperation3     |   callback.onSuccess()
     * onSuccess()
     */
}