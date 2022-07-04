class Calculator{
    
    Add(a,b)
    {
        if(typeof a != "number" || typeof b != "number"  )
            return 0;
            
        return a+b;
    }
    
    Sub(a,b)
    {
         if(typeof a != "number" || typeof b != "number"  )
            return 0;
            
        return a-b;
    }
    
    Mul(a,b)
    {
         if(typeof a != "number" || typeof b != "number"  )
            return 0;
            
        return a*b;
    }
    
    Div(a,b)
    {
         if(typeof a != "number" || typeof b != "number"  )
            return 0;
            
        if (b == 0) 
            return 0;
        else
            return a/b;
    }
    
    Cal(a,op,b)
    {
         if(typeof a != "number" || typeof b != "number" || typeof op != "string"  )
            return 0;
        
        switch(op)
        {
            case "+":
                return this.Add(a,b);
                break;
            case "-":
                return this.Sub(a,b);
                break;
            case "*":
                return this.Mul(a,b);
                break;
            case "/":
                return this.Div(a,b);
                break;
           
        }
       return 0;
    }
    
}

let cal = new Calculator();

console.log(cal.Cal(10,"/",2))
