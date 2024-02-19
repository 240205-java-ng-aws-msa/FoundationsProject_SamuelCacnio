async function register(){
    const url = "http://localhost:8080/register"

    const logInfo = {
        email: document.getElementById("email-input").value,
        password: document.getElementById("pass-input").value
    };
    const warning = document.getElementById("warning");
    if (logInfo.password.length < 8){
        warning.innerHTML = "Password must be at least 8 characters."
        document.getElementById("pass-input").value = "";
        return;
    }
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
            console.log(data);
            const accountInfo = document.getElementById("account");
            while (accountInfo.firstChild){
                accountInfo.lastChild.remove();
            }
            const logName = document.createTextNode("Welcome new user: "+data.email);
            accountInfo.appendChild(logName);
            
            const logOut = document.createElement("input");
            logOut.type = "button";
            logOut.value = "Logout";
            logOut.setAttribute("onclick", "logout()");
            accountInfo.appendChild(logOut);
        }
        else if (res.status === 400){
            warning.innerHTML = "Account already exits. Try Login.";
        }
        else{
            warning.innerHTML = "Something went wrong. Please try again.";
            document.getElementById("email-input").value = "";
            document.getElementById("pass-input").value = "";
        }
    }
    catch (err){
        window.location.reload();;
    }
}   