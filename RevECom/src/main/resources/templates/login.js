async function login(){
    const url = "http://localhost:8080/login"

    const logInfo = {
        email: document.getElementById("email-input").value,
        password: document.getElementById("pass-input").value
    };

    const warning = document.getElementById("warning");

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
            console.log(data.email);
            const accountInfo = document.getElementById("account");
            while (accountInfo.firstChild){
                accountInfo.lastChild.remove();
            }
            const logName = document.createTextNode("Logged in as: "+data.email);
            accountInfo.appendChild(logName);
            
            const logOut = document.createElement("input");
            logOut.type = "button";
            logOut.value = "Logout";
            logOut.setAttribute("onclick", "logout()");
            accountInfo.appendChild(logOut);
        }
        else if (res.status === 401){
            warning.innerHTML = "Invalid credentials. Try again.";
            document.getElementById("email-input").value = "";
            document.getElementById("pass-input").value = "";
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