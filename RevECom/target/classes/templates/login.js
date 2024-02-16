async function login(){
    const url = "http://localhost:8080/login"

    const logInfo = {
        email: document.getElementById("email-input").value,
        password: document.getElementById("pass-input").value
    };

    try{
        const res = await fetch(url, {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            },
            body: JSON.stringify(logInfo)
            }
        );
        if (res.status === 200){
            const data = await res.json();
            const accountInfo = document.getElementById("account");
            while (accountInfo.firstChild){
                accountInfo.lastChild.remove();
            }
            const logName = document.createElement("p");
            logName.innerHTML = data.email;
        }
        /*let message = document.getElementById("warning");
        message.textContent="logged!";*/
        //window.location.href = "./store.html"
    }
    catch (err){
        console.log("FAILED");
    }
}