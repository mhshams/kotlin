// "Add label to loop" "true"
fun breakContinueInWhen(i: Int) {
    loop@ for (x in 0..10) {
        loop1@ for (y in 0..10) {
            when(i) {
                0 -> co<caret>ntinue@loop1
                2 -> {
                for(z in 0..10) {
                    break
                }
                for(w in 0..10) {
                    continue
                }
            }
            }
        }
    }
}
